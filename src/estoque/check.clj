(ns estoque.check)

"Estudo de metodologia de construção de funções"

(defn valor-descontado
  "Retorna o valor com desconto de 10%"
  [valor-bruto]
  (if (> valor-bruto 100)
    (let [taxa-de-desconto (/ 10 100)
          desconto (* valor-bruto taxa-de-desconto)]
      (- valor-bruto desconto))
    valor-bruto))

(println (valor-descontado 85))


"Quebra em partes menores de código"
(defn aplicar-desconto?
  [valor-bruto]
  (> valor-bruto 100))


(aplicar-desconto? 101)

(defn calcula-desconto
  [valor-bruto]
  (let [taxa-de-desconto 0.10
        desconto (* valor-bruto taxa-de-desconto)]
    (- valor-bruto desconto)))

(calcula-desconto 100)

(defn operacao
  [valor-bruto]
  (if (aplicar-desconto? valor-bruto)
    (calcula-desconto valor-bruto)
    valor-bruto))

(operacao 102)