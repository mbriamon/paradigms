;; question2.clj

(ns taxation)

(defn tax [amount rate]
  (* amount (/ rate 100.0)))

(ns application
  (:require [taxation :refer [tax]]))

(defn -main []
  (let [amount 117
        rate 7
        result (tax amount rate)]
    (println (format "Tax: %.2f" result))))


(-main)
