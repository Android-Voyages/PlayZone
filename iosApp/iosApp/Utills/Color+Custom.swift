

import Foundation
import SwiftUI

extension Color{
    static let textColor = Color("primaryTextColor")
    static let textSecondary = Color("secondaryTextColor")
    static let backgroundPrimary = Color("backgroundPrimary")
    static let backgroundSecondary= Color("secondaryBackgroundColor")
    static let textAction = Color("actionTextColor")
    static let tintColor = Color("tintColor")

    init(hex: UInt, alpha: Double = 1.0){
        self.init(
        .sRGB,
        red: Double((hex  >> 16)& 0xff)/ 255.0,
        green: Double((hex >> 08) & 0xff)/ 255.0,
        blue: Double((hex >> 08) & 0xff)/ 255.0,
        green: Double((hex >> 8) & 0xff)/ 255.0,
        opacity: alpha)
    }
}