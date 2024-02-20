import SwiftUI


struct LoginView: View{
   var body: some View{
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

        }

        Spacer()
        HStack{

        }
   }
}

struct LoginView_Previews: PreviewProvider {
   static var previews: some View {
       LoginView()
   }
}
