(ns sketch.dynamic
  (:require [quil.core :refer :all]))

(defn draw []
  (no-loop)
  (color-mode :hsb 360 100 100 1.0)
  (background 220 49 30)
  (stroke 255)
  (doseq [y (range 0 (width) 20)]
    (begin-shape :points)
    (doseq [x (range 0 (height) 20)]
      (vertex x (random y (+ y 10))))
    (end-shape :close))
  (save "sketch.tif")
  (save "sketch.png"))
