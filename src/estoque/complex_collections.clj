(ns estoque.complex-collections
  (:require [estoque.db :as e.db]))

; Para chamar funcoes de outros arquivos
(e.db/todos-pedidos)

(group-by :usuario (e.db/todos-pedidos))

(vals (group-by :usuario (e.db/todos-pedidos)))

; Pouco legível
(map count (vals (group-by :usuario (e.db/todos-pedidos))))

; Problema de perder quem é o usuário
(->> (e.db/todos-pedidos)
     (group-by :usuario)
     vals
     (map count))

; Implementação para manter o identificador do usuário

(defn not-nil
  [x]
  (not (nil? x)))

(defn calcula-valor
  [[prod infos]]
  (let [qtd (-> infos :quantidade)
        val (-> infos :preco-unitario)]
    (if (not (nil? val))
      (do
        (* qtd val)))))

(defn total-item
  [item]
  (->> (map calcula-valor (:itens item))
       (filter not-nil)
       (reduce +)))

(defn gasto-total
  [pedidos]
  (map total-item pedidos))

(defn qtdpedidos-e-gastototal-por-usuario
  [[usuario pedidos]]
  {
   :usuario-id  usuario
   :qtd-pedidos (count pedidos)
   :gasto-total (reduce + (gasto-total pedidos))})

(->> (e.db/todos-pedidos)
     (group-by :usuario)
     (map qtdpedidos-e-gastototal-por-usuario))
