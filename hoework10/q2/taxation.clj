(ns taxation)

(defn tax [amount rate]
  (/ (* amount rate) 100.0))

