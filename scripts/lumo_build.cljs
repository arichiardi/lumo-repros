(require '[lumo.build.api :as b])

(b/build (b/inputs "src/cljs" "src/js")
         {:main 'speed-of-light.core
          :output-to "out/speed_of_light.js"
          :optimizations :none
          :source-map true
          :libs ["src/js"]
          :target :nodejs
          :verbose true})
