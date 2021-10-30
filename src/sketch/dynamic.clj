(ns sketch.dynamic
  (:require [quil.core :refer :all]))

(def step 20)

(defn distance-to-center [x width]
  (Math/abs (- x (/ width 2))))

; Math.max((width / 2) - 50 - distanceToCenter, 0)
(defn variance [x width]
  (max (- (/ width 2) 50 (distance-to-center x width)) 0))

(defn displacement [x w]
  (let [distortion (random 1)]
    (* (/ (* distortion (variance x w)) 2) -1)))

(defn draw []
  (no-loop)
  (color-mode :hsb 360 100 (height) 1.0)
  (background 220 80 (/ (height) 3))
  (stroke 360)
  (stroke-weight 3)
  (blend-mode :replace)
  (doseq [y (range 100 (- (height) 50) step)]
    (begin-shape)
    (fill 40 60 y)
    (doseq [x (range 0 (+ step (width)) step)]
      (vertex x (+ y (displacement x (width)))))
    (end-shape))
  (save "sketch.tif")
  (save "sketch.png"))
