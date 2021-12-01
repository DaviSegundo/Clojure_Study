(ns estoque.logic)

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

(defn resumo-por-user
    [pedidos]
    (->> pedidos
         (group-by :usuario)
         (map qtdpedidos-e-gastototal-por-usuario)))
