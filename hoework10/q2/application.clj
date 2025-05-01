(ns application
  (:require [taxation :as t]))

(defn -main []
  (let [amount 117
        rate 7
        computed-tax (t/tax amount rate)]
    (println computed-tax)))

