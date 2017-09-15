(ns speed-of-light.core
  "The entry point of this program")

(enable-console-print!)

(defn ^:export -main
  [& args]
  (println "Hello World!"))

(set! *main-cli-fn* -main)
