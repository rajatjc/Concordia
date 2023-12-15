(ns abc
  (:require [xyz :as xyz]))

(defn use-xyz-greet []
  (xyz/greet))

(use-xyz-greet)

