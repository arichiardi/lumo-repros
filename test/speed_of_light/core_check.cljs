(ns speed-of-light.core-check
  (:require [speed-of-light.core :as core]
            [cljs.spec.test.alpha :as stest])
  (:require-macros [cljs.spec.test.alpha :as stest]))

(println "test.check crunching...")

(stest/check 'speed-of-light.core/ranged-rand)
