(ns advent.day1
  (:require 
    [clojure.java.io :as io]))


(def input
  (->> 
    "day1.txt"
    io/resource
    slurp
    (mapv #(Character/getNumericValue %))))


(defn part1 [xs]
  (->>
     (for [i (range (count xs))
          :let [ys (conj (vec (rest xs)) (first xs))]
          :when  (= (get xs i) (get ys i))]
          (get xs i))
     (reduce + 0)))


(defn part2 [xs]
  (let [len (count xs)
        sep (/ len 2)]
  (->>
    (for [i (range len)
         :let [ys (vec (concat (drop sep xs) (take sep xs)))]
         :when  (= (get xs i) (get ys i))]
         (get xs i))
    (reduce + 0))))

(comment
  (part2 input)
)