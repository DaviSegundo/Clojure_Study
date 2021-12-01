(ns estoque.ordenate-reverse
    (:require [estoque.db :as e.db]
              [estoque.logic :as e.lg]))

(e.lg/resumo-por-user (e.db/todos-pedidos))

(defn resume [] (e.lg/resumo-por-user (e.db/todos-pedidos)))

(resume)

(sort-by :gasto-total > (resume))

(filter #(= % 15) (resume))

(defn checar-num
    [dados nume]
    (if (= nume (:usuario-id dados))
        (do
            dados)))

(filter #(not (nil? %)) (map #(checar-num % 15) (resume)))

(->> (resume)
     (sort-by :gasto-total)
     reverse
     (take 2))

(->> (resume)
     (filter #(> (:gasto-total %) 500))
     (sort-by :qtd-pedidos)
     reverse)