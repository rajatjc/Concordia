(ns test.foo
  (:require test.bar )
  (:require [test.baz :as baz]))


(println "running foo...")

(print "barFunc 67: ")
(println (test.bar/barFunc 67)) 

; this will not work sicne its private in test.bar
;(println (test.bar/hidden 6)) 


(print "bazFunc 94: ")
(println (baz/bazFunc 94))

(print "bazVar: ")
(println baz/bazVar)


