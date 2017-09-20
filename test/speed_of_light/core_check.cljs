(ns speed-of-light.core-check
  (:require [speed-of-light.core :as core]
            [cljs.spec.test.alpha :as stest :include-macros true]))

(println "test.check crunching...")

(stest/check 'speed-of-light.core/ranged-rand)
