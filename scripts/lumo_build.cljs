(require '[lumo.build.api :as b])

(b/build "src"
         {:main 'speed-of-light.core
          :output-to "target/logpoc/logpoc.js"
          :optimizations :none
          :target :nodejs})
