
import SharedSDK
import Combine



func statePublisher<T>(_ flow: KviewModelWrappedStateFlow<T>) -> AnyPublisher<T, Never> {
    return Deferred<Publishers.HandleEvents<PassthroughSubject<T,Never>>>{
        let subject = PassthroughSubject<T,Never>()
        let closeable = flow.watch{next int
         if let next =  next{
             subject.send(next)
         }
        }

        return subject.handleEvents(receiveCancel: {
            closeable.close()
        })
    }.eraseToAnyPublisher()
}


func sharePublisher<T>(_ flow: KviewModelWrappedSharedFlow<T>) -> AnyPublisher<T, Never> {
    return Deferred<Publishers.HandleEvents<PassthroughSubject<T,Never>>>{
        let subject = PassthroughSubject<T,Never>()
        let closeable = flow.watch{next int
        subject.send(next)

        }

        return subject.handleEvents(receiveCancel: {
            closeable.close()
        })
    }.eraseToAnyPublisher()
}
