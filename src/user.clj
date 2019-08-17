(ns user
  (:require [clojure.tools.namespace.repl :as ns-repl]
            [clojure.inspector :as inspector]
            [clojure.spec.test.alpha :as st]
            [meander.match.delta :as m]
            #_[orchestra.spec.test :as st]))

;; Defaults to make life easier
;; in repl
(defn dev-settings!
  []
  (do (alter-var-root #'*print-length* (constantly 20))
      (alter-var-root #'*print-level* (constantly 6))))

(dev-settings!)
(st/instrument)

;; Examples taken from meander readme
#_(m/match [1 2]
       ;; Pair of equivalent objects.
       [?a _]
       ?a)
#_(m/match {:a 1}
         {:b ?b}
         ?b)
(m/match 42
       (pred even?)
       :okay)

(defn reset []
  (ns-repl/refresh ))
