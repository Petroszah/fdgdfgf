require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /
    state: Start
        q!: $regex</start>
        a: Начнём.

    state: hello
        intent!: /hello
        q!: *(добрый*|привет|салют|здравст*|хэллоу|алло)*
        random:
            a: Привет! Чем могу помочь?
            a: Здравствуйте! Чем могу помочь?
    
    state: weather
        intent!: /weather
        q!: *(погода|прогноз|дождь|солнце)*
        random:
            a: Сегодня будет солнечно!
            a: Сегодня будет дождь!
            a: Сегодня будет облачно!
                
    state: currency
        intent!: /currency
        q!: *(~валюта|курс)*
        random:
            a: Доллар 30, Евро 40
            a: Доллар 90, Евро 100
            a: Юань 10
        
    state: NoMatch
        event!: noMatch
        random:
            a: Вы точно хотели сказать: {{$request.query}}?
            a: Я не понял. Вы сказали: {{$request.query}}