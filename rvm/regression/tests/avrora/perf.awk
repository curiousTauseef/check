#
# (C) Copyright IBM Corp. 2005
#
# $Id: perf.awk,v 1.1 2005/02/02 14:24:18 hind-oss Exp $
#
# @author Michael Hind

# collect index results for summary line
/Time for simulation/ { sec = $4; next }

# ignore everything else
/.*/ { next }

# print summary at the end
END {
    print "Bottom Line(Seconds): " sec
}
