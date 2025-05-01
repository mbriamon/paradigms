;; question3.clj

;; Read and process the temperature data
(let [file-contents (slurp "temperatures.txt")
      lines (clojure.string/split file-contents #"\n")
      fahrenheit-values (map #(Double/parseDouble %) lines)
      celsius-values (map #(-> (- % 32) (* 5/9)) fahrenheit-values)
      min-temp (apply min celsius-values)
      max-temp (apply max celsius-values)
      avg-temp (/ (reduce + celsius-values) (count celsius-values))]

  ;; Print results
  (println (str "Min Temperature (°C): " min-temp))
  (println (str "Max Temperature (°C): " max-temp))
  (println (str "Avg Temperature (°C): " avg-temp)))
