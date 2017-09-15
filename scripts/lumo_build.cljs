(require '[lumo.build.api :as api])

(def compiler-opts
  {:main 'speed-of-light.core
   :output-to "out/speed_of_light.js"
   :optimizations :none
   :source-map true
   :target :nodejs
   :verbose true})

(api/build
 (api/inputs "src") ;; variadic
 compiler-opts
 (fn [result]
   (if-let [err (:error result)]
     (println (.-stack err))
     (do (println "Complete!")
         (println result)))))
