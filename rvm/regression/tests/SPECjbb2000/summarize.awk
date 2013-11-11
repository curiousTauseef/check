#
# (C) Copyright IBM Corp. 2001
#
# $Id: summarize.awk,v 1.3 2001/11/02 18:08:37 pfs-oss Exp $
#
# @author Julian Dolby

BEGIN {
    no = "no";
    yes = "yes";
    in_details = no;
}

/Valid run, Score is/ { print "Bottom Line: " $0 }

/\* Details of Runs/ { in_details = yes }

/[0-9]*[:whitespace:]*[0-9]*[:whitespace:]*[0-9.]*[:whitespace:]*[0-9.]*[:whitespace:]*[0-9.<]*[:whitespace:]*[0-9.<]*[:whitespace:]*new_order/ {
    if ($1 == 1)
      print "score for", $1, "warehouse is", $2;
    else
      print "score for", $1, "warehouses is", $2;
}

    
