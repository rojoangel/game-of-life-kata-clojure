(ns game-of-life.core-test
  (:require [clojure.test :refer :all]
            [game-of-life.core :refer :all]))

(deftest game-of-life-tests
  (testing "blinker oscillator"
    (let [board #{(->Cell 1 0) (->Cell 1 1) (->Cell 1 2)}]
      (is (= board (first (play 1 board))))
      (is (= #{(->Cell 0 1) (->Cell 1 1) (->Cell 2 1)} (second (play 1 board))))
      (is (= board (nth (play 2 board) 2)))))
  (testing "block still life"
    (let [block #{(->Cell 1 1) (->Cell 1 2) (->Cell 2 1) (->Cell 2 2)}]
      (is (= block (first (play 1 block))))
      (is (= block (second (play 1 block)))))))
