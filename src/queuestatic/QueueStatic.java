package queuestatic;

public class QueueStatic {
    private int[] queue; // Propriedade que armazena a fila.
    private int size; // Propriedade que armazena o tamanho real da fila.
    
    // Construror que recebe como parametro um int que representa o tamanho da Fila.
    public QueueStatic(int size) {
        // Iniciando uma exceção caso o argumento passado seja menor ou igual a zero.
        if(size <= 0) throw new IllegalArgumentException("Invalid size arguments");
        // Definindo o tamanho da fila.
        this.queue = new int[size];
        // Definindo a quantidade de elementos na fila.
        this.size = 0;
    }
    
    // Fazendo override do construtor para que seja possivel omitir os parametros.
    public QueueStatic() {
        // Chamando o contrutor e passando como parâmetro o tamanho da fila como 10.
        this(10);
    }
    
    // Metodo que retorna a quantidade de itens na fila.
    public int size() {
        return this.size;
    }
    
    // Metodo que retorna um int representado a capacidade todal da fila.
    public int getCapacity() {
        return this.queue.length;
    }
    
    // Metodo que retorna true caso a fila esteja vazia e false caso contrário.
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    // Metodo que retorna true caso a fila esteja cheia e false caso contrário.
    public boolean isFull() {
        return this.size == this.getCapacity();
    }
    
    // Metodo para adicionar um novo item na fila.
    public void add(int item) {
        // Iniciando uma exceção caso a fila esteja cheia.
        if(this.isFull()) throw new ArrayIndexOutOfBoundsException("Queue is Full");
        
        // Adicionando um item no final da fila.
        this.queue[this.size] = item;
        // Incrementado um item na propriedade que armazena o tamanho da fila.
        this.size++;
    }
    
    // Metodo pra remover item.
    public void remove() {
        // Iniviando um exceção caso a fila esteja vazia.
        if(this.isEmpty()) throw new IllegalStateException("Queue is Empty");
        
        // Removendo o primeiro item da fila e transferindo o elemento da 2 posição para a primeira, a 3 posição para a segunda e assim por diante. (Fazendo a Fila andar).
        for(int i = 0; i < this.size; i++) {
            // verifica se é o último item da fila
            if(i + 1 != this.size )
                this.queue[i] = this.queue[i+1];
        }
        // Decrementando um item da propriedade que armazena o tamanho da fila.
        this.size--;
    }
    
    // Metodo que possibilita aumentar a fila depois de inicializada.
    public void resize(int size) {
        // Inicia uma exceção caso o tamanho passado como parâmetro for menor que a quantidade de itens na fila.
        if(size < this.size || size == 0) throw new IllegalArgumentException("Ivalid size arguments");
        
        // Criando uma nova fila do tamanho passado como parâmetro.
        int[] newQueue = new int[size];
        //  Copiando os itens da antiga fila para a nova.
        for(int i = 0; i < this.size; i++) {
            newQueue[i] = this.queue[i];
        }
        // Sobrescrevendo o parâmetro que armazena a fila com a nova fila
        this.queue = newQueue;
    }
    
    // Metodo que possibilita saber quem está ocupando determinado posição na fila
    public int getPosition(int position) {
        // Iniciando uma exceção caso a posição não seja válida
        if(position < 0 | position > this.size) throw new IllegalArgumentException("Invalid position argument");
        
        // Retorna a o item que está na posição passada como parâmetro
        return this.queue[position];
    }
}
