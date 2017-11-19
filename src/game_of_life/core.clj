(ns game-of-life.core)

(defrecord Cell [x y])

(defn neighbors [cell]
  (for [x-delta [-1 0 1]
        y-delta (if (zero? x-delta) [-1 1] [-1 0 1])]
    (->Cell (+ (:x cell) x-delta) (+ (:y cell) y-delta))))

(defn step [board]
  (set (for [[loc n] (frequencies (mapcat neighbors board))
             :when (or (= n 3) (and (= n 2) (board loc)))]
         loc)))

(defn play [n board]
  (take (+ n 1) (iterate step board)))