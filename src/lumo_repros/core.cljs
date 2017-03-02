(ns lumo-repros.core
  (:require #_[aws-sdk :as AWS]
            #_[clojure.browser.repl :as repl]))

;; (defonce conn
;;   (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)

(def AWS (js/require "aws-sdk"))

(defn ^:export -main
  [& args]
  (println "Hello world!"))

(set! *main-cli-fn* -main)
