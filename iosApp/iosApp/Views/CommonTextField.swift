
import SwiftUI


struct CommonTextField: View {
    let onValueChanged: (String) -> Void
    @State private var value: String = ""
    private let hint: String
    private let enabled: Bool
    private let isSecure: Bool

    init(hint:String, enabled: Bool = true, isSecure: Bool = false, onValueChanged: @escaping (String) -> Void){
        self.hint = hint
        self.enabled = enabled
        self.isSecure = isSecure
        self.onValueChanged = onValueChanged
    }
    var body: some View {
        ZStack(alignment: .leading){
            RoundedRectangle(cornerRadius: 10)
                .foregroundColor(Color.backgroundSecondary)

             if(value.isEmpty){
                Text(hint)
                    .foregroundColor(Color.textPrimary.opacity(0.5))
                    .font(.system(size: 16))
                    .padding(EdgeInserts(top: 0, leading: 20, bottom: 0, trailing: 20))

            }

            if isSecure{
                   SecureField("", text: value)
                                                  .padding(EdgeInserts(top: 0, leading: 16, bottom: 0, trailing: 16))
                                                  .foregroundColor(.textPrimary)
                                                  .font(.system(size: 16))
                                                  .autoCapitalization(.none)
                                                  .disableAutocorrection(true)
                                                  .disabled(!enabled)
                                                  .padding(EdgeInserts(top: 16, leading: 30, bottom: 0, trailing: 30))
                                                  .onChange(of: value{newValue in
                                                      onValueChanged(newValue)
                                                  })
            }else{
                  TextField("", text: value)
                                .padding(EdgeInserts(top: 0, leading: 16, bottom: 0, trailing: 16))
                                .foregroundColor(.textPrimary)
                                .font(.system(size: 16))
                                .autoCapitalization(.none)
                                .disabled(!enabled)
                                .disableAutocorrection(true)
                                .padding(EdgeInserts(top: 16, leading: 30, bottom: 0, trailing: 30))
                                .onChange(of: value{newValue in
                                    onValueChanged(newValue)
                                })
            }





        }
            .frame(height: 50)
            .padding(EdgeInserts(top: 0, leading: 24, bottom: 0, trailing: 24))

    }
}


struct CommonTextField_Previews: PreviewProvider {
    static var previews: some View {
        CommonTextField(hint: "Your Email",enabled: Bool = true,isSecure:Bool = true, onValueChanged:(String)->Void){ newValue in
            print(newValue)
        })
    }
}