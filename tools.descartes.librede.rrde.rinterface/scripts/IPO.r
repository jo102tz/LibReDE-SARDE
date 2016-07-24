# vim:tw=80:ts=2:sw=2:colorcolumn=81:nosmartindent
#
# Qais Magic Optimization Algorithm
# --------------
# Author: Dominik Bruhn <dominik@dbruhn.de>
#
# Algorithm described in: 
# Qais Noorshams, Dominik Bruhn, Samuel Kounev, and Ralf Reussner.
# Predictive Performance Modeling of Virtualized Storage Systems using 
# Optimized Statistical Regression Techniques. In Proceedings of the 
# ACM/SPEC International Conference on Performance Engineering, Prague, 
# Czech Republic, ICPE 13, pages 283-294, New York, NY, USA. ACM. 2013.
# Default values for techniques
#
# This script was adapted by Johanes Grohmann to use it in the Java LibReDE tool, 2016.

#importing is done by the Java interface beforehand
#install.packages("rJava")
#install.packages("data.table")
#library(rJava)
#library(data.table)

optimizeParams<-function(java, ranges, nSplits=10, nExplorations=50,
                             nIterations=15,trace=0) {
  # This method optimizes the parameters 
  
  
  d<-function(x) {
    if(trace>1) {
      print(x)
    }
  }
  
  stopifnot(nSplits>0)
  stopifnot(nExplorations>0)
  stopifnot(nIterations>0)
  
  #Add one sample to E
  E1_Params = data.table(expand.grid(ranges))[1,]
  d("E1_Params is")
  d(E1_Params)
  
  E1_Value = evaluate(java, E1_Params)
  d("E1_Value is")
  d(E1_Value)
  
  E = cbind(E1_Params, quality=E1_Value, iterationNo=0)
  setkeyv(E, setdiff(names(E), c("quality", "iterationNo")))
  M = E
  
  d("Before first iteration:")
  d("E")
  d(E)
  d("M")
  d(M)
  
  iterNo = 1
  repeat {
    Ej = E[0] #Ej is empty 
    
    #Iterate over M
    by(M, 1:nrow(M), function(Mrow) {
      d("Inspecting row")
      d(Mrow)
      
      x = Mrow[,1:(length(Mrow)-2), with=FALSE] #all except last 2 column 2]
      d("x is")
      d(x)
      #y = Mrow[length(Mrow)] #last column]
      
      #For each parameter find lower and upper limits
      S = yapply(x, function(xv) {
        d(paste("Inspecting parameter",NAMES))
        range = ranges[[NAMES]]
        d("Ranges:")
        d(range)
        extValues = E[[NAMES]]
        d("Extisting Values:")
        d(extValues)
        d(paste("Current Value:", xv))
        
        d(paste("lower check=",extValues[extValues<xv]))
        lowerBorder = max(extValues[extValues<xv], range[1])
        upperBorder = min(extValues[extValues>xv], range[2])
        d(paste("lower=",lowerBorder,"upper=",upperBorder))
        
        
        
        return(makeValueValid(method, NAMES,
                              unique(seq(lowerBorder, upperBorder, length=nSplits+2))
        ))
      })
      d("Calculated new values")
      d(S)
      
      #Expand new Values
      Sexp = data.table(expand.grid(S))
      d("Calculated expanded values")
      d(Sexp)
      
      #Evaluate these values
      by(Sexp, 1:nrow(Sexp), function(SexpRow) {
        d("Evaluating")
        d(SexpRow)
        
        #Check if already exists in E
        if(is.na(E[SexpRow]$quality) &
             is.na(Ej[SexpRow]$quality)) {
          d("Row is not in E")
          
          res = evaluate(java, SexpRow)
          d(paste("Results is ", res))
          
          Ej <<- rbind(Ej, cbind(SexpRow, quality=res, iterationNo=iterNo))
          
          #Need to update the key because rbind destroys it
          setkeyv(Ej, setdiff(names(Ej), c("quality", "iterationNo")))
        }
      })
    })
    
    d("Ej is now")
    d(Ej)
    
    d("After each M was evaluated:")
    E = rbind(E, Ej)
    setkeyv(E, setdiff(names(E), c("quality", "iterationNo")))
    d(E)
    
    #Get top quality parameters
    thisNExplorations = nExplorations
    M = E[order(quality),][1:min(thisNExplorations,nrow(E)) ]
    d("M is now")
    d(M)
    
    #Stop Condition
    if(trace>=1) {
      cat(paste("Iteration ",iterNo,"/",nIterations,
                ": #E=",nrow(E),", #Ej=",nrow(Ej)," Best:\n",
                sep=""))
      print(M[1,])
    }
    
    if(iterNo>=nIterations) {
      break
    }
    iterNo = iterNo+1
  }
  
  return(E[order(quality), ])
}

# Evaluate for a given thechnique the model with the given parameters
evaluate<-function(java, params) {
  #todo
}

# Enforce for each parameter of a method that the value is valid
makeValueValid<-function(java, value) {
  return(value)
}
