(ns time-test.core
  (:require [clj-time.core :as t]
            [clj-time.format :as f]
            [clj-time.periodic :as p]))

(def my-formatter (f/formatter "dd/MM/yyyy"))

(defn loop-months [start-date-str end-date-str]
  (let [start-date (f/parse my-formatter start-date-str)
        end-date (f/parse my-formatter end-date-str)]
    (->> (p/periodic-seq start-date (t/months 1))
         (take-while #(t/before? % end-date))
         (map #(print (str "Got this date " %))))))
