class Carro{
  private String placa;
  private int anoFabricacao;

  public Carro(String placa, int anoFabricacao){
    this.placa = placa;
    this.anoFabricacao = anoFabricacao;
  }

  public String getPlaca(){
    return placa;
  }

  public int getAnoFabricacao(){
    return anoFabricacao;
  }

  public int calcularImposto(int anoAtual){
    int idade = anoAtual - anoFabricacao;
    if (idade >= 10){
      return 0;
     }
      int imposto = 500 - (idade * 100);
      return Math.max(imposto, 100);
  }
}