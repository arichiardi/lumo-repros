(ns speed-of-light.core
  "The entry point of this program"
  (:require [speed-of-light.macros :as m :include-macros true]))

(enable-console-print!)

(defn ^:export -main
  [& args]
  (println (m/read-json-safely "{\"hello\": \"World\"}")))

(set! *main-cli-fn* -main)
