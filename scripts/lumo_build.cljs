(require '[lumo.build.api :as b])

(b/build "src"
         {:main 'speed-of-light.core
          :output-to "out/speed_of_light.js"
          :optimizations :none
          :source-map true
          :target :nodejs
          :verbose true})
