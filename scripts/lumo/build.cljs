(require '[lumo.build.api :as api])

(enable-console-print!)

(def compiler-opts
  {:main 'speed-of-light.core
   :output-to "out/speed_of_light.js"
   :optimizations :none
   :source-map true
   :target :nodejs
   :verbose true})

(api/build
 "src"
 compiler-opts
 #(do
    (println "\nCompilation Result")
    (if-let [err (:error %)]
      (println err)
      (println "Success (result: " % ")"))))
