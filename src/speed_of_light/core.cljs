(ns speed-of-light.core
  "The entry point of this program"
  (:require [clojure.spec.alpha :as s]))

(enable-console-print!)

(s/fdef ranged-rand
  :args (s/and (s/cat :start int? :end int?)
               #(< (:start %) (:end %)))
  :ret int?
  :fn (s/and #(>= (:ret %) (-> % :args :start))
             #(< (:ret %) (-> % :args :end))))

(defn ranged-rand  ;; BROKEN!
  "Returns random int in range start <= rand < end"
  [start end]
  (+ start (long (rand (- start end)))))

(defn ^:export -main
  [& args]
  (println (ranged-rand 1 4)))

(set! *main-cli-fn* -main)
