;; question1.clj

;; Get command-line arguments and parse the first one as an integer
(def n (Integer/parseInt (first *command-line-args*)))

;; Generate the sequence of squares from 1 to n
(def squares (map #(* % %) (range 1 (inc n))))

;; Print each square on a new line
(doseq [sq squares]
  (println sq))

;; Compute the sum of the squares
(def sum (reduce + squares))

;; Print the sum
(println (str "Sum = " sum))
