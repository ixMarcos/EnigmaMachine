# EnigmaMachine
Simulador da maquina de criptografia Enigma

## Classe Main
Essa classe contém o método main que é o ponto de entrada do programa. 
Ele cria os objetos necessários, configura a máquina Enigma e oferece ao usuário a opção de criptografar ou decifrar uma mensagem. 
Esta classe faz uso de outras classes como Rotor, EnigmaMachine e Plugboard.

## Classe Rotor
Essa classe representa um rotor da máquina Enigma. Cada rotor contém uma posição, uma configuração de cabeamento e uma posição de entalhe. 
Os rotores podem ser girados e usados para criptografar ou decifrar uma mensagem.

- setInitialPosition(int position): Define a posição inicial do rotor.
- rotate(): Gira o rotor.
- processForward(int input): Criptografa a entrada usando o cabeamento do rotor. A entrada é um inteiro no intervalo de 0 a 25 e a saída também é um inteiro no intervalo de 0 a 25.
- processBackward(int input): Decifra a entrada usando o cabeamento do rotor. A entrada é um inteiro no intervalo de 0 a 25 e a saída também é um inteiro no intervalo de 0 a 25.
- setWiring(String wiringString): Define a configuração de cabeamento do rotor. O argumento é uma string de 26 caracteres que especifica a configuração do cabeamento. Cada caractere representa uma entrada do cabeamento e a posição na string representa a saída correspondente.
- setNotchPosition(int notchPosition): Define a posição do entalhe do rotor.
- atNotch(): Verifica se o rotor está na posição do entalhe.

## Classe EnigmaMachine
Essa classe representa a máquina Enigma completa, que consiste em um conjunto de rotores e um plugboard. Ele pode ser configurado com as posições iniciais dos rotores e as configurações do plugboard. Ele também pode ser usado para criptografar ou decifrar mensagens.
- EnigmaMachine(Rotor[] rotors, Plugboard plugboard): Cria um objeto EnigmaMachine com o conjunto de rotores especificado e o plugboard especificado.
- configureRotors(int[] rotorPositions): Configura as posições iniciais dos rotores.
- configurePlugboard(String plugboardSettings): Configura as configurações do plugboard.
- encryptMessage(String message): Criptografa uma mensagem usando a máquina Enigma e retorna a mensagem criptografada.
- decryptMessage(String message): Decifra uma mensagem usando a máquina Enigma e retorna a mensagem decifrada.

## Classe PlugBoard
A classe Plugboard representa um componente da máquina de criptografia Enigma. O Plugboard permite que os usuários da máquina troquem pares de letras antes da criptografia ser realizada pelos rotores. 
O Plugboard tem um conjunto padrão de pares de letras que são trocadas, mas os usuários também podem definir sua própria configuração.
- configure(String settings): Configura o Plugboard com uma nova configuração, que é uma string de pares de letras separados por espaços. Cada par de letras representa um cabo que conecta essas letras no Plugboard. Por exemplo, "AT BS DE FM IR KN LZ OW PV XY" configura o Plugboard para trocar A por T, B por S, D por E, etc.
- process(int input): Recebe uma letra como entrada e retorna a letra correspondente depois de passar pela configuração atual do Plugboard. Se a letra não estiver conectada a nenhuma outra no Plugboard, a letra original é retornada.

  