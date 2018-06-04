(ns advent.day2
  (:require 
    [clojure.java.io :as io]
    [clojure.string  :as str]))

    
(def input
 (->
   "day2.txt"
   io/resource
   slurp
   (str/split #"\n")
   (->>
    (map #(str/split % #"\t"))
    (map #(map (fn [x] (Long/parseLong x)) %)))))


;; part 1
(defn min-max [xs]
    [(apply min xs) (apply max xs)])


(defn part1 [xs]
  (reduce + (map (fn [[a b]] (- b a)) (map min-max xs))))


;; part 2
(defn pairs [xs]
  (for [x xs, y xs
       :when (not= x y)]
   [x y]))
  

(defn div-by? [m n]
  (zero? (mod m n)))
  

(defn part2 [xs]
  (reduce + (map (fn [[a b]] (/ a b))
            (mapcat #(filter (fn [[x y]] (div-by? x y)) (pairs %)) xs))))
  

(comment
  (part2 input)
)  

