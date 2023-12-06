# RetrofitCryptoKotlin



1.Retrofit ve RxJava Kullanımı: Veri alma ve işleme için Retrofit kütüphanesini ve RxJava'yı kullanma. Retrofit, API çağrılarını yapmak ve verileri almak için kullanılırken, RxJava ise bu çağrıların asenkron olarak işlenmesini ve arayüz güncellemeleri için ana iş parçacığına geri dönüş yapmayı sağlar.

2.RecyclerView Kullanımı: Verileri liste halinde göstermek için RecyclerView kullanma. RecyclerView, veri kümesini döngüsel bir liste olarak görüntülemek için kullanılır ve kullanıcı arayüzünde listeleme işlevselliği sağlar.

3.Model Sınıfları ve Veri Bağlama (Data Binding): Verileri saklamak ve işlemek için CryptoModel adlı bir model sınıfı oluşturma. Ayrıca, veri bağlama (data binding) kullanarak bu model sınıfını XML dosyalarında kullanma (ActivityMainBinding gibi).

4.Asenkron Veri İşleme: API çağrılarını ve veri işleme işlemlerini arka planda yapmak için RxJava'nın schedulers'larını (Schedulers.io() ve AndroidSchedulers.mainThread()) kullanma. Bu, ana iş parçacığının (main thread) kitlenmesini önler ve uygulama performansını artırır.

5.Error Handling: API çağrılarının başarısız olması durumunda hata yönetimi için try-catch blokları kullanma veya RxJava'nın onError() fonksiyonunu kullanma.

6.Disposable Nesnelerin Kullanımı: RxJava'da CompositeDisposable kullanarak, aktivitenin yaşam döngüsü boyunca kullanılan ve temizlenen (clear) disposable nesneleri yönetme.

7.Veri Görselleştirme ve Kullanıcı Etkileşimi: RecyclerView üzerinde tıklama olayları yakalama ve bu olaylara göre Toast mesajları gösterme. Bu, kullanıcı etkileşimlerini algılamak ve buna yanıt olarak belirli işlemler yapmak için kullanılır.

CoinApi den çekilmiştir kripto bilgileri.
