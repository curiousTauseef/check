#
# (C) Copyright IBM Corp. 2002
#
# $Id: perf.awk,v 1.1 2002/07/08 18:50:44 sjfink-oss Exp $
#
# @author Stephen Fink

# collect index results for summary line
/Soot has run for/ { sec = 60*$5 + 7; next }

# ignore everything else
/.*/ { next }

# print summary at the end
END {
    print "Bottom Line(Seconds): " sec
}
