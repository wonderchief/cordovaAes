//
//  cordovaAes.h
//  好知音
//
//  Created by wonderchief on 16/1/22.
//
//

#import <Cordova/CDV.h>

@interface cordovaAes : CDVPlugin
@property (copy, nonatomic)NSMutableArray *returns;
@property (copy) NSString* callbackId;

- (void)encrypto:(CDVInvokedUrlCommand*)command;
- (void)decrypto:(CDVInvokedUrlCommand*)command;

@end
