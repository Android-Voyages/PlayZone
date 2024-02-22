

import SwiftUI
import SharedSDK

struct LoginView: View{

   private let loginViewModel = LoginViewModel

   var body: some View{
        VStack{
            VStack{
                Spacer().frame(height: 36)
                Text("Login Now")
                  .font(.system(size: 24)
                  .fontWeight(.bold)
                  .foregroundColor(.textPrimary)


                Text("Welcome back to PlayZone! Enter your email addres and your password to enjoy the latest features of PlayZone")
                  .foregroundColor(.textPrimary.opacity(0.5))
                  .fixedSize(horizontal: false, vertical: true)
                  .multilineTextAlignment(.center)
                  .padding(EdgeInserts(top: 16, leading: 30, bottom: 0, trailing: 30))

                Spacer().frame(height: 50)

                CommonTextField(hint: "Login",enabled: true,isSecure: false){newValue in
                    loginViewModel.obtainEvent(viewEvent: .EmailChanged(value: newValue))
                }

                Spacer().frame(height: 24)

                CommonTextField(hint: "Password",enabled: true,isSecure: true){newValue in
                    loginViewModel.obtainEvent(viewEvent: .PasswordChanged(value: newValue))
                }

                LoginActionView(
                    onForgotClicked: {
                        loginViewModel.obtainEvent(viewEvent: .ForgotPasswordClicked)
                    },
                    onSubmitClicked: {
                        loginViewModel.obtainEvent(viewEvent: .LoginClicked)
                    }
                )
            }

              Spacer()

              HStack{
                    Text("Don't have an account?")
                        .foregroundColor(.textPrimary.opacity(0.5))
                        .opacity(0.5)

                    Text("Create one")
                        .foregroundColor(.tintColor)
                        .font(.bold)
                        .onTypeGesture{
                            loginViewModel.obtainEvent(viewEvent: .RegisterClicked)
                        }

              }
        }
   }
}

struct LoginActionView:View{

     let onForgotClicked: () -> Void
     let onSubmitClicked: () -> Void
     var body: some View{
        VStack{
            Spacer().frame(height: 30)
            HStack{
                Spacer()
                Text("Forgot Password?")
                    .foregroundColor(.tintColor)
                    .onTypeGesture{
                        onForgotClicked()
                    }
                Spacer().frame(width: 30)
                ActionButton(title: "Login now", enabled: true){
                    onSubmitClicked()
                }
            }
            Spacer().frame(height: 30)
        }
     }

}

struct LoginView_Previews: PreviewProvider {
   static var previews: some View {
       LoginView()
            .background(Color.backgroundPrimary)
   }
}
