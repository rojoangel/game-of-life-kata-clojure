(ns game-of-life.core)

(defrecord Cell [x y])

(defn neighbors [cell]
  (for [dx [-1 0 1] dy (if (zero? dx) [-1 1] [-1 0 1])]
    (->Cell (+ (:x cell) dx) (+ (:y cell) dy))))

(defn step [board]
  (set (for [[loc n] (frequencies (mapcat neighbors board))
        :when (or (= n 3) (and (= n 2) (board loc)))]
    loc)))

(defn play [n board]
  (take (+ n 1) (iterate step board)))