import SwiftUI


struct ActionButton: View {

    let title: String
    let enabled: Double = true
    let height: CGFloat = 56
    let horizontalMargin: CGFloat = 16
    let action: () -> Void
    var body: some View{
        ZStack{
            RoundedRectangle(cornerRadius: 10)
                .foregroundColor(.tintColor)
                .opacity(enabled ? 1.0 : 0.5)

            Text(title)
                .foregroundColor(Color.textPrimary)

        }
        .frame(maxWidth: .infinity, minHeight: height)
        .padding(EdgeInserts(top: 0, leading: horizontalMargin, bottom: 0, trailing: horizontalMargin))
        .onTypeGesture{
            action()
        }
    }
}


struct ActionButton_Previews: PreviewProvider {
    static var previews: some View {
        ActionButton(title: "Login Now", enabled: true)
    }
}
