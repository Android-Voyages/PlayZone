

import SwiftUI
import SharedSDK



struct LoginView: View{

   let viewState: LoginViewState
   let eventHandler: (LoginEvent) -> Void

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

                CommonTextField(hint: "Login",enabled: !viewState.isSending){newValue in
                    eventHandler(.EmailChanged(value: newValue)
                }

                Spacer().frame(height: 24)

                CommonTextField(hint: "Password",enabled: !viewState.isSending,isSecure: !viewState.passwordHidden){newValue in
                    eventHandler(.PasswordChanged(value: newValue)
                }

                LoginActionView(
                    onForgotClicked: {
                        eventHandler(.ForgotPasswordClicked)
                    },
                    onSubmitClicked: {
                        eventHandler(.LoginClicked)
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
                           eventHandler(.CreateAccountClicked)
                        }

              }
        }
   }
}

struct LoginActionView:View{
     let viewState: LoginViewState
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

            }
            Spacer().frame(height: 30)
            ActionButton(title: "Login now", enabled: !viewState.isSending){
                                onSubmitClicked()
            }
            .frame(height: 56)
            Spacer()
        }
     }

}

struct LoginView_Previews: PreviewProvider {
   static var previews: some View {
       LoginView(viewState: LoginViewState(email: "asfa@mail.ru",password: "12e12",isSending: false,passwordHidden: true), eventHandler: {_ in})
            .background(Color.backgroundPrimary)
            .background(ignoreSafeAreaEdges(.top, .bottom))
   }
}
