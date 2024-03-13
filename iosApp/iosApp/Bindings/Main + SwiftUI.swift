import SwiftUI
import SharedSDK

struct MainComposeView: UIViewControllerRepresentable{
    func makeUIViewController(context: Context) -> some UIViewController{
        Main_iosKt.MainViewController()
    }
    func updateUIViewController(_ uiViewController: UIViewControllerType,context: Context){

    }
}