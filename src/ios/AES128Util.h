//
//  AES128Util.m
//
//  Created by wonderchief on 16/02/17.
//  Copyright (c) 2015 legle.cc All rights reserved.
//

#import <Foundation/Foundation.h>

@interface AES128Util : NSObject

+(NSString *)AES128Encrypt:(NSString *)plainText key:(NSString *)key;

+(NSString *)AES128Decrypt:(NSString *)encryptText key:(NSString *)key;

+ (NSString *) md5:(NSString *)str;
+(NSString *)convertDataToHexStr:(NSData *)data ;

@end
