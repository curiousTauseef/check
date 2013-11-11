#
# (C) Copyright IBM Corp. 2001
#
#
# $Id: perf.awk,v 1.3 2002/07/01 21:28:04 sjfink-oss Exp $
#
# @author Stephen Fink
#

# collect the total time, throwing out the first iteration
BEGIN {
  iter = 0
  eTime = 0
}

/Method:/ {
  method = $2
}

/ELAPSED TIME/ { 
   if (iter > 0)  {
     eTime = eTime + $3; 
   }
   iter = iter + 1
   next 
}

# ignore everything else
/.*/ { next }

# print summary at the end
END {
    print method " Elapsed Time(ms): " eTime
}
