#
# (C) Copyright IBM Corp. 2001
#
#
# $Id: perf.awk,v 1.3 2001/11/02 18:08:54 pfs-oss Exp $
#
# @author Julian Dolby
#

# collect index results for summary line
/Integer Index/ { intPerf = $3; next }
/FP Index/ { fpPerf = $3; next }

# pass thru individual results
/^[ A-Za-z]*:[^A-Za-z]*$/ { print $0 }

# ignore everything else
/.*/ { next }

# print summary at the end
END {
    print "Bottom Line: Integer Index " intPerf ", FP Index ", fpPerf;
}
