(require '[lumo.build.api :as b])

(b/build "src"
         {:main 'speed-of-light.core
          :output-to "target/speed_of_light.js"
          :optimizations :none
          :source-map false
          :target :nodejs})
